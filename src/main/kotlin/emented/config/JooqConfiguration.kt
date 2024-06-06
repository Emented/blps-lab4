package emented.config

import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.core.annotation.Order
import javax.sql.DataSource

@Configuration
@Order(Int.MIN_VALUE)
class JooqConfiguration {

    @Bean("mainDslContext")
    @DependsOn("mainDataSource")
    fun mainDslContext(@Qualifier("mainDataSource") mainDataSource: DataSource): DSLContext {
        return DSL.using(mainDataSource, SQLDialect.POSTGRES)
    }

    @Bean
    @DependsOn("mainDataSource")
    fun jooqConfigUser(mainDataSource: DataSource): DefaultConfiguration {
        val config = DefaultConfiguration()
        config.set(DataSourceConnectionProvider(mainDataSource))
        config.set(SQLDialect.POSTGRES)
        return config
    }
}