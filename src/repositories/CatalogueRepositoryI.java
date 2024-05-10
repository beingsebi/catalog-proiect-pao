package repositories;

import models.Catalogue;

public interface CatalogueRepositoryI {
    int insertCatalogue(Catalogue catalogue);

    Catalogue getCatalogueById(int catalogueId);

    void removeCatalogue(int catalogueId);

    boolean catalogueExists(int catalogueId);

    void updateCatalogue(int catalogueId, Catalogue catalogue);

}
