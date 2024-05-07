package repositories;

import models.Catalogue;

public interface CatalogueRepositoryI {
    int insertCatalogue(Catalogue catalogue);
    Catalogue getCatalogueById(int catalogueId);
    int removeCatalogue(Catalogue catalogue);
}
