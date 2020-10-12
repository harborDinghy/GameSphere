package models;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Builder
@Data
public class Author {
    @NotNull String name;
}
