package uk.ac.ucl.mappingtool.v2.domain.documentLink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.description.Description;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Language;
import uk.ac.ucl.mappingtool.v2.domain.title.Title;
import uk.ac.ucl.mappingtool.v2.domain.type.Type;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocLink {
    private String url;
    private Type format;
    private List<Category> categories;
    private List<Language> languages;
    private Title title;
    private DocumentDate document_date;
    private Description description;
}
