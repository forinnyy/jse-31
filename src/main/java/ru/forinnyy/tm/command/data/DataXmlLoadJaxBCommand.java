package ru.forinnyy.tm.command.data;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.forinnyy.tm.dto.Domain;
import ru.forinnyy.tm.enumerated.Role;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public final class DataXmlLoadJaxBCommand extends AbstractDataCommand {

    @Override
    public String getArgument() {
        return null;
    }

    @NonNull
    @Override
    public String getDescription() {
        return "Load data from xml file.";
    }

    @NonNull
    @Override
    public String getName() {
        return "data-load-xml-jaxb";
    }

    @NonNull
    @Override
    public Role[] getRoles() {
        return new Role[]{Role.ADMIN};
    }

    @Override
    @SneakyThrows
    public void execute() {
        System.out.println("[DATA LOAD XML]");
        @NonNull JAXBContext jaxbContext = JAXBContext.newInstance(Domain.class);
        @NonNull final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        @NonNull final File file = new File(FILE_XML);
        @NonNull final Domain domain = (Domain) unmarshaller.unmarshal(file);
        setDomain(domain);
    }

}
