package ru.sberbank.jd.lesson10;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.input.Cd;
import ru.sberbank.jd.lesson10.output.Album;
import ru.sberbank.jd.lesson10.output.Artist;
import ru.sberbank.jd.lesson10.output.Country;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс для чтения и записи объекта в Json, Xml, byte формате.
 */
public class WriteRegistry {
    /**
     * Метод main для запуска процессов.
     */
    public static void main(String[] args) {
        Path path = Paths.get("lesson10/src/main/resources/input/cd_catalog.xml");
        Catalog catalog = DeserializationObject.deserialization(new Catalog(), path);
        List<Cd> cds = catalog.getCds();
        List<Country> countries = streamToCounty(cds);

        Registry registry = new Registry(countries, countries.size());
        serialization(registry);
    }

    /**
     * Метод содержит поток в List из Country
     * распределяет альбомы каждому артисту
     * после разбивает артистов по странам.
     *
     * @param cds список дисков.
     * @return List стран с артистами.
     */
    public static List<Country> streamToCounty(List<Cd> cds) {
        List<Country> countries = cds.stream()
                .collect(Collectors.groupingBy(
                        Cd::getCountry,
                        Collectors.groupingBy(
                                Cd::getArtist,
                                Collectors.mapping(
                                        cd -> new Album(cd.getTitle(), cd.getYear()),
                                        Collectors.toList()
                                )
                        )
                ))
                .entrySet().stream()
                .map(entry -> new Country(entry.getKey(), entry.getValue()
                        .entrySet().stream()
                        .map(artistEntry -> new Artist(artistEntry.getKey(), artistEntry.getValue()))
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
        return countries;

    }

    /**
     * Метод для записи объектов.
     *
     * @param registry список стран с артистами.
     */
    public static void serialization(Registry registry) {
        SerializationObject<Registry> serializations = new SerializationXml<>();
        serializations.serialization(registry);

        serializations = new SerializationJson<>();
        serializations.serialization(registry);

        serializations = new SerializationByte<>();
        serializations.serialization(registry);
    }
}


