package Config;

import Entities.Compte;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;


@Provider
@Produces({"application/xml"})
public class CompteListMessageBodyWriter implements MessageBodyWriter<List<Compte>> {
    public CompteListMessageBodyWriter() {
    }

    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return List.class.isAssignableFrom(type) && mediaType.isCompatible(MediaType.APPLICATION_XML_TYPE);
    }

    public void writeTo(List<Compte> comptes, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{Compte.class});
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(comptes, entityStream);
        } catch (Exception var10) {
            throw new IOException(var10);
        }
    }
}