package com.cjx913.es.service;

import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;

public interface FileService {
    String wordToPdf(@NotNull final String paperId) throws URISyntaxException;
}
