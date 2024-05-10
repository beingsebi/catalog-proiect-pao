package repositories;

import models.Catalogue;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CatalogueRepository implements CatalogueRepositoryI {

    @Override
    public int insertCatalogue(Catalogue catalogue) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "INSERT INTO catalogues (name, description, class_year, class_symbol, supervisorId, courseInstanceRepoId) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
            int courseRepoId = CourseInstanceRepository.createCourseInstanceRepo();
            if (courseRepoId == -1) {
                return -1;
            }
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, catalogue.getCatalogueName());
            stmt.setString(2, catalogue.getCatalogueDescription());
            stmt.setInt(3, catalogue.getClassYear());
            stmt.setString(4, catalogue.getClassSymbol());
            stmt.setInt(5, catalogue.getClassSupervisorId());
            stmt.setInt(6, courseRepoId);
            var rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            con.close();
            return id;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Catalogue getCatalogueById(int catalogueId) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM catalogues WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, catalogueId);
            var rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Catalogue catalogue = new Catalogue(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("class_year"),
                    rs.getString("class_symbol"), rs.getInt("supervisorId"), rs.getInt("courseInstanceRepoId"));
            con.close();
            return catalogue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeCatalogue(int catalogueId) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "DELETE FROM catalogues WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, catalogueId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean catalogueExists(int catalogueId) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "SELECT * FROM catalogues WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, catalogueId);
            var rs = stmt.executeQuery();
            con.close();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateCatalogue(int catalogueId, Catalogue catalogue) {
        try {
            Connection con = DbUtils.getConnection();
            assert con != null;
            String sql = "UPDATE catalogues SET name = ?, description = ?, class_year = ?, class_symbol = ?, supervisorId = ?, courseinstancerepoid = ?  WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, catalogue.getCatalogueName());
            stmt.setString(2, catalogue.getCatalogueDescription());
            stmt.setInt(3, catalogue.getClassYear());
            stmt.setString(4, catalogue.getClassSymbol());
            stmt.setInt(5, catalogue.getClassSupervisorId());
            stmt.setInt(6, catalogue.getCourseInstanceRepository().getCourseInstanceRepositoryId());
            stmt.setInt(7, catalogueId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
