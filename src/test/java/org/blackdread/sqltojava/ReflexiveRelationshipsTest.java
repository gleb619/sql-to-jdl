package org.blackdread.sqltojava;

import org.blackdread.sqltojava.extension.MySqlLatestExtension;
import org.blackdread.sqltojava.shared.interfaces.CompareJdlResultsTest;
import org.blackdread.sqltojava.shared.tests.BaseJdbcContainerTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@ExtendWith(MySqlLatestExtension.class)
public class ReflexiveRelationshipsTest
    extends BaseJdbcContainerTest
    implements CompareJdlResultsTest {

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add(
            "spring.flyway.locations",
            () -> "classpath:db/self-reference"
        );
        registry.add("application.export.path", () -> "./reflexive.jdl");
        registry.add(
            "expected.result.path",
            () -> "/result/reflexive-expected.jdl"
        );
    }
}
