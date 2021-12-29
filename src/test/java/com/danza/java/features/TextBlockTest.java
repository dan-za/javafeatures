package com.danza.java.features;

import org.junit.jupiter.api.Test;

/**
 * @since Java 15
 */
public class TextBlockTest {

    /**
     * https://openjdk.java.net/jeps/378
     * <p>
     * A text block is a multi-line string literal that avoids the need for most escape sequences,
     * automatically formats the string in a predictable way, and gives the developer control over the format when desired.
     */
    @Test
    void useTextBlock() {

        var myHtmlTextBlock = """
                     <html>
                        <body>
                            <p>Hello!</b>
                        </body>
                     </html>
                """;

        var myQueryTextBlock = """
                select "c1" from "t1" 
                where "c2" = 'whatever' 
                order by "c1" asc;   
                """;

    }

}
