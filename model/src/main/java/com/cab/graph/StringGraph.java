package com.cab.graph;

import com.cab.graph.entity.Links;
import com.google.gson.Gson;
import lombok.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;

public class StringGraph extends Graph<String> {

    @Override
    public void loadFromJson(final @NonNull String jsonFileName) {
        final URL url = this.getClass().getClassLoader().getResource(jsonFileName);
        if (url == null) {
            throw new FileSystemNotFoundException("File not found: " + jsonFileName);
        }
        final StringBuilder jsonString = new StringBuilder();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) jsonString.append(line);
            reader.close();

            Links links = new Gson().fromJson(jsonString.toString(), Links.class);
            for (com.cab.graph.entity.Link link : links){
                if (!this.hasAlreadyNodeValuedAs(link.nodes()[0])) this.getNodes().add(new Node<>(link.nodes()[0]));
                if (!this.hasAlreadyNodeValuedAs(link.nodes()[1])) this.getNodes().add(new Node<>(link.nodes()[1]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Gson toJson() {
        return null;
    }

    private boolean hasAlreadyNodeValuedAs(final String node) {
        return this.getNodes().stream().anyMatch(n -> n.getValue().equals(node));
    }

}
