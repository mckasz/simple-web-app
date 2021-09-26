package com.sages.jdp.simplewebapp.planetary;

import java.io.IOException;

public class PlanetaryService {

    private WebClient webClient;

    public PlanetaryService(WebClient webClient) {
        this.webClient = webClient;
    }

    public APOD getPicture() throws IOException {
        String content = webClient.get("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        return JsonMapper.deserialize(content, APOD.class);
    }
}
