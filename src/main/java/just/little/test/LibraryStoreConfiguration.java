package just.little.test;

import io.jmix.autoconfigure.data.JmixLiquibaseCreator;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import io.jmix.core.JmixModules;
import io.jmix.core.Resources;
import io.jmix.data.impl.JmixEntityManagerFactoryBean;
import io.jmix.data.impl.JmixTransactionManager;
import io.jmix.data.persistence.DbmsSpecifics;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

@Configuration
public class LibraryStoreConfiguration {

    @Bean
    @ConfigurationProperties("library.datasource")
    DataSourceProperties libraryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "library.datasource.hikari")
    DataSource libraryDataSource(@Qualifier("libraryDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean libraryEntityManagerFactory(
            @Qualifier("libraryDataSource") DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter,
            DbmsSpecifics dbmsSpecifics,
            JmixModules jmixModules,
            Resources resources
    ) {
        return new JmixEntityManagerFactoryBean("library", dataSource, jpaVendorAdapter, dbmsSpecifics, jmixModules, resources);
    }

    @Bean
    JpaTransactionManager libraryTransactionManager(@Qualifier("libraryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JmixTransactionManager("library", entityManagerFactory);
    }

    @Bean("libraryLiquibaseProperties")
    @ConfigurationProperties(prefix = "library.liquibase")
    public LiquibaseProperties libraryLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean("libraryLiquibase")
    public SpringLiquibase libraryLiquibase(@Qualifier("libraryDataSource") DataSource dataSource,
                                            @Qualifier("libraryLiquibaseProperties") LiquibaseProperties liquibaseProperties) {
        return JmixLiquibaseCreator.create(dataSource, liquibaseProperties);
    }
}
