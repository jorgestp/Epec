package es.uned.lsi.eped.pract2016.parser;

import es.uned.lsi.eped.pract2016.AcademiaIF;

public interface OperationsParser {
    void getSiblings(AcademiaIF academia, int doctorId);

    void getDescendants(AcademiaIF academia, int doctorId, int generations);

    void getStudents(AcademiaIF academia, int doctorId);

    void getAncestors(AcademiaIF academia, int doctorId, int generations);

    void getDirectors(AcademiaIF academia, int doctorId);
}
