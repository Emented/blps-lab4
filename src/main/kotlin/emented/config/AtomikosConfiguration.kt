package emented.config

import com.atomikos.icatch.jta.UserTransactionImp
import com.atomikos.icatch.jta.UserTransactionManager
import com.atomikos.jdbc.AtomikosDataSourceBean
import jakarta.transaction.TransactionManager
import jakarta.transaction.UserTransaction
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Primary
import org.springframework.core.annotation.Order
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.jta.JtaTransactionManager
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@Order(Integer.MIN_VALUE)
class AtomikosConfiguration {

    @Primary
    @Bean("mainDataSource")
    fun mainDataSource(): DataSource {
        val dataSource = AtomikosDataSourceBean()
        dataSource.uniqueResourceName = "xads1-main-db"
        dataSource.xaDataSourceClassName = "org.postgresql.xa.PGXADataSource"
        dataSource.xaProperties.setProperty("serverName", "localhost")
        dataSource.xaProperties.setProperty("portNumber", "5432")
        dataSource.xaProperties.setProperty("databaseName", "blps-main")
        dataSource.xaProperties.setProperty("user", "postgres")
        dataSource.xaProperties.setProperty("password", "postgres")
        return dataSource
    }

    @Bean("archiveDataSource")
    fun archiveDataSource(): DataSource {
        val dataSource = AtomikosDataSourceBean()
        dataSource.uniqueResourceName = "xads2-archive-db"
        dataSource.xaDataSourceClassName = "org.postgresql.xa.PGXADataSource"
        dataSource.xaProperties.setProperty("serverName", "localhost")
        dataSource.xaProperties.setProperty("portNumber", "5432")
        dataSource.xaProperties.setProperty("databaseName", "blps-archive")
        dataSource.xaProperties.setProperty("user", "postgres")
        dataSource.xaProperties.setProperty("password", "postgres")
        return dataSource
    }

    @Primary
    @Bean("atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
    fun atomikosTransactionManager(): TransactionManager {
        val userTransactionManager = UserTransactionManager()
        userTransactionManager.forceShutdown = false
        return userTransactionManager
    }

    @Primary
    @Bean("userTransaction")
    fun userTransaction(): UserTransaction {
        val userTransactionImp = UserTransactionImp()
        userTransactionImp.setTransactionTimeout(5)
        return userTransactionImp
    }

    @Primary
    @Bean("transactionManager")
    @DependsOn("userTransaction", "atomikosTransactionManager")
    fun transactionManager(): PlatformTransactionManager {
        val userTransaction = userTransaction()
        val atomikosTransactionManager = atomikosTransactionManager()
        return JtaTransactionManager(userTransaction, atomikosTransactionManager)
    }
}