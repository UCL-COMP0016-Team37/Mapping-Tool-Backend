package uk.ac.ucl.mappingtool.v2.domain.activity.documentLink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.description.Description;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.narrative.Language;
import uk.ac.ucl.mappingtool.v2.domain.activity.title.Title;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

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
