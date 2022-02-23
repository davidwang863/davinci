package edp.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LdapConfig {
    private LdapTemplate ldapTemplate;

    @Value("${spring.ldap.urls:''}")
    private String ldapUrl;

    @Value("${spring.ldap.base-dn}")
    private String baseDN;

    @Value("${spring.ldap.bind-dn}")
    private String bindDN;

    @Value("${spring.ldap.password}")
    private String password;

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();

        Map<String, Object> config = new HashMap();
        config.put("java.naming.ldap.attributes.binary", "objectGUID");

        contextSource.setUrl(ldapUrl);
        contextSource.setBase(baseDN);
        contextSource.setUserDn(bindDN);
        contextSource.setPassword(password);
        contextSource.setPooled(true);
        contextSource.setBaseEnvironmentProperties(config);

        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        if (null == ldapTemplate) {
            ldapTemplate = new LdapTemplate(contextSource());
        }
        ldapTemplate.setIgnorePartialResultException(true);
        return ldapTemplate;
    }
}
