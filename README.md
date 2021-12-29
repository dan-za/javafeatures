# Java Features

## Long Term Support (LTS)

List for [Eclipse Temurin](https://adoptium.net/index.html) (formerly known as AdoptOpenJDK)

https://adoptium.net/support.html

| Java Version | Release date   |   Support until   |
|--------------|----------------|:-----------------:|
| 8            | March 2014     | At Least May 2026 |
| 11           | September 2018 | At Least Oct 2024 |
| 17           | September 2021 |    March 2022     |

| Since Java Version | Description                                                                            |                                                               Example                                                                |
|--------------------|----------------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------:|
| 8                  | Stream API                                                                             |                            [StreamAPITest.java](src/test/java/com/danza/java/features/StreamAPITest.java)                            |
| 8                  | [JEP 126: Lambda Expressions and method references](https://openjdk.java.net/jeps/126) | [LambdaExpressionsAndMethodReferencesTest.java](src/test/java/com/danza/java/features/LambdaExpressionsAndMethodReferencesTest.java) |
| 8                  | [JEP 150: Date & Time API](https://openjdk.java.net/jeps/150)                          |                       [DateAndTimeAPITest.java](src/test/java/com/danza/java/features/DateAndTimeAPITest.java)                       |
| 8                  | Optional                                                                               |                             [OptionalTest.java](src/test/java/com/danza/java/features/OptionalTest.java)                             |
| 8                  | @FunctionalInterface                                                                   |                  [FunctionalInterfaceTest.java](src/test/java/com/danza/java/features/FunctionalInterfaceTest.java)                  |
| 8                  | Interface default and static methods                                                   |     [InterfaceDefaultAndStaticMethodsTest.java](src/test/java/com/danza/java/features/InterfaceDefaultAndStaticMethodsTest.java)     |
| 9                  | Interface private methods (JEP 213)                                                    |              [InterfacePrivateMethodsTest.java](src/test/java/com/danza/java/features/InterfacePrivateMethodsTest.java)              |
| 9                  | Modules                                                                                |                                         https://openjdk.java.net/projects/jigsaw/quick-start                                         |
| 10                 | Local variables (var keyword)                                                          |                        [LocalVariableTest.java](src/test/java/com/danza/java/features/LocalVariableTest.java)                        |
| 11                 | New string methods (repeat, lines, isBlank, strip)                                     |                     [NewStringMethodsTest.java](src/test/java/com/danza/java/features/NewStringMethodsTest.java)                     |
| 11                 | New http client                                                                        |                           [HttpClientTest.java](src/test/java/com/danza/java/features/HttpClientTest.java)                           |
| 11                 | javac no longer needed to compile a file before running it.                            |                                        java src/main/java/com/danza/java/features/MyApp.java                                         |
| 12                 | New string methods (indent, transform)                                                 |                     [NewStringMethodsTest.java](src/test/java/com/danza/java/features/NewStringMethodsTest.java)                     |
| 12                 | CompactNumberFormat                                                                    |                  [CompactNumberFormatTest.java](src/test/java/com/danza/java/features/CompactNumberFormatTest.java)                  |
| 12                 | New NIO method (mismatch)                                                              |                                  [NioTest.java](src/test/java/com/danza/java/features/NioTest.java)                                  |
| 14                 | [JEP 361: Switch Expressions](https://openjdk.java.net/jeps/361)                       |                    [SwitchExpressionsTest.java](src/test/java/com/danza/java/features/SwitchExpressionsTest.java)                    |
| 15                 | [JEP 378: Text Blocks](https://openjdk.java.net/jeps/378)                              |                            [TextBlockTest.java](src/test/java/com/danza/java/features/TextBlockTest.java)                            |
| 16                 | [JEP 395: Records](https://openjdk.java.net/jeps/395)                                  |                              [RecordsTest.java](src/test/java/com/danza/java/features/RecordsTest.java)                              |
| 16                 | [JEP 394: Pattern Matching for instanceof](https://openjdk.java.net/jeps/394)          |                           [InstanceOfTest.java](src/test/java/com/danza/java/features/InstanceOfTest.java)                           |
| 17                 | [JEP 409: Sealed Classes](https://openjdk.java.net/jeps/409)                           |                        [SealedClassesTest.java](src/test/java/com/danza/java/features/SealedClassesTest.java)                        |
