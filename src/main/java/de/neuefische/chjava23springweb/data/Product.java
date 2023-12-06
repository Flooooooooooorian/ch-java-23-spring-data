package de.neuefische.chjava23springweb.data;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public record Product(
        String id,
        String title,
        int price
) {
}
