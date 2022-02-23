package edp.davinci.model;

import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class LdapPersonAttributesMapper implements AttributesMapper {
    public Object mapFromAttributes(Attributes attrs) throws NamingException {
        LdapPerson ldapPerson = new LdapPerson();

        if(attrs.get("mail") != null) ldapPerson.setEmail(attrs.get("mail").get().toString());

        return ldapPerson;
    }
}
