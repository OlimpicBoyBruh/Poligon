

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;
import ru.sberbank.jd.lesson10.output.Registry;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeserializationObjectTest {

    @Test
    public void deserializationByteTest() {
        try (InputStream is = Files.newInputStream(Path.of("C:\\Users\\olimp\\OneDrive\\Рабочий стол\\myProject\\home-assignments-1023\\lesson10\\src\\test\\resources\\artist_by_country.serialized"));
             ObjectInputStream ois = new ObjectInputStream(is)) {
            Registry registry = (Registry) ois.readObject();
            Assert.assertEquals(4, registry.getCountryCount());
            Assert.assertEquals("Savage Rose", registry.getCountries().get(0).getArtists().get(0).getName());
            Assert.assertEquals("EU", registry.getCountries().get(0).getName());
            Assert.assertEquals(7, registry.getCountries().get(1).getArtists().size());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void deserializationXmlTest() {
        XmlMapper mapper = new XmlMapper();
        File file = new File("C:\\Users\\olimp\\OneDrive\\Рабочий стол\\myProject\\home-assignments-1023\\lesson10\\src\\test\\resources\\artist_by_country.xml");
        try {
           Registry registry = mapper.readValue(file, Registry.class);

            Assert.assertEquals(4, registry.getCountryCount());
            Assert.assertEquals("Savage Rose", registry.getCountries().get(0).getArtists().get(0).getName());
            Assert.assertEquals("EU", registry.getCountries().get(0).getName());
            Assert.assertEquals(7, registry.getCountries().get(1).getArtists().size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deserializationJsonTest() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("C:\\Users\\olimp\\OneDrive\\Рабочий стол\\myProject\\home-assignments-1023\\lesson10\\src\\test\\resources\\artist_by_country.json");
        try {
            Registry registry = objectMapper.readValue(file, Registry.class);

            Assert.assertEquals(4, registry.getCountryCount());
            Assert.assertEquals("Savage Rose", registry.getCountries().get(0).getArtists().get(0).getName());
            Assert.assertEquals("EU", registry.getCountries().get(0).getName());
            Assert.assertEquals(7, registry.getCountries().get(1).getArtists().size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
