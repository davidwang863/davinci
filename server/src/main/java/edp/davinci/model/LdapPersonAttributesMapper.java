package edp.davinci.model;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.support.DefaultIncrementalAttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class LdapPersonAttributesMapper implements AttributesMapper<LdapPerson> {
    @Override
    public final LdapPerson mapFromAttributes(Attributes attrs) throws NamingException {
        LdapPerson ldapPerson = new LdapPerson();

        if(attrs.get("mail") != null) ldapPerson.setEmail(attrs.get("mail").get().toString());

        return ldapPerson;
    }
}
