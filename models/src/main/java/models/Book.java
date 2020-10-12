package models;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Builder
@Data
public class Book {
   @NotNull String bookName;
   @NotNull @ToString.Exclude @EqualsAndHashCode.Exclude Author author;
}
