package dnd.dal;

import dnd.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterJobDao {
    private CharacterJobDao() {}

    public static CharacterJob create(Connection cxn,
                                      GameCharacter character,
                                      Job job,
                                      int level,
                                      int experiencePoints,
                                      boolean unlocked) throws SQLException {
        String sql = "INSERT INTO CharacterJob (characterID, jobName, level, experiencePoints, unlocked) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setString(2, job.name());
            stmt.setInt(3, level);
            stmt.setInt(4, experiencePoints);
            stmt.setBoolean(5, unlocked);

            stmt.executeUpdate();

            return new CharacterJob(job, character, level, experiencePoints, unlocked);
        }
    }

    public static CharacterJob getCharJobFromCharIDJobID(Connection cxn,
                                                         GameCharacter character,
                                                         Job job) throws SQLException {
        String sql = "SELECT level, experiencePoints, unlocked FROM CharacterJob " +
                     "WHERE characterID = ? AND jobName = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setString(2, job.name());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int level = rs.getInt("level");
                    int exp = rs.getInt("experiencePoints");
                    boolean unlocked = rs.getBoolean("unlocked");

                    return new CharacterJob(job, character, level, exp, unlocked);
                } else {
                    return null;
                }
            }
        }
    }

    public static List<CharacterJob> getAllJobsForCharacter(Connection cxn,
                                                            GameCharacter character) throws SQLException {
        String sql = "SELECT jobName, level, experiencePoints, unlocked FROM CharacterJob WHERE characterID = ?";
        List<CharacterJob> jobs = new ArrayList<>();

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Job job = Job.valueOf(rs.getString("jobName"));
                    int level = rs.getInt("level");
                    int exp = rs.getInt("experiencePoints");
                    boolean unlocked = rs.getBoolean("unlocked");

                    jobs.add(new CharacterJob(job, character, level, exp, unlocked));
                }
            }
        }

        return jobs;
    }

    public static CharacterJob updateExperiencePoints(Connection cxn,
                                                      GameCharacter character,
                                                      Job job,
                                                      int newExp) throws SQLException {
        String sql = "UPDATE CharacterJob SET experiencePoints = ? WHERE characterID = ? AND jobName = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, newExp);
            stmt.setInt(2, character.getCharacterID());
            stmt.setString(3, job.name());

            int affected = stmt.executeUpdate();
            if (affected == 0) return null;

            return getCharJobFromCharIDJobID(cxn, character, job);
        }
    }

    public static void delete(Connection cxn, GameCharacter character, Job job) throws SQLException {
        String sql = "DELETE FROM CharacterJob WHERE characterID = ? AND jobName = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setString(2, job.name());
            stmt.executeUpdate();
        }
    }
}
