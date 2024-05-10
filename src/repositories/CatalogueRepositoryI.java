package repositories;

import models.Catalogue;

import java.util.ArrayList;

public interface CatalogueRepositoryI {
    int insertCatalogue(Catalogue catalogue);

    Catalogue getCatalogueById(int catalogueId);

    void removeCatalogue(int catalogueId);

    boolean catalogueExists(int catalogueId);

    void updateCatalogue(int catalogueId, Catalogue catalogue);

    ArrayList<Catalogue> getAllCatalogues();
}
