package repositories;

import models.Catalogue;

import java.util.Set;

public class CatalogueRepository implements CatalogueRepositoryI{
    public Set<Catalogue> catalogues;

    @Override
    public int insertCatalogue(Catalogue catalogue) {
        catalogues.add(catalogue);
        return catalogue.getCatalogueId();
    }

    @Override
    public Catalogue getCatalogueById(int catalogueId) {
        for (Catalogue catalogue : catalogues) {
            if (catalogue.getCatalogueId() == catalogueId) {
                return catalogue;
            }
        }
        return null;
    }

    @Override
    public int removeCatalogue(Catalogue catalogue) {
        boolean ok = catalogues.remove(catalogue);
        if (!ok) {
            return -1;
        }
        return catalogue.getCatalogueId();
    }
}
