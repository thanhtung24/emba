package example2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {

    /**
     * Gruppiert Elemente in der Liste basierend auf einem angegebenen Schlüsselselektor und wendet eine Funktion
     * auf jede Gruppe an, um ein Ergebnis zu erzeugen. Die Ergebnisse werden in einer Map gesammelt, bei der
     * die Schlüssel die Gruppierungsschlüssel und die Werte die Ergebnisse der angewendeten Funktion sind.
     *
     * <p>Die zurückgegebene Map enthält einen Eintrag pro Gruppe, bei dem der Schlüssel das Ergebnis
     * der Anwendung des Schlüsselselektors auf die Elemente ist, und der Wert das Ergebnis der Anwendung
     * der bereitgestellten Funktion auf die Liste der Elemente in dieser Gruppe.
     *
     * @apiNote
     * Zum Beispiel, um eine Liste von Ganzzahlen nach ihrer Parität (gerade oder ungerade) zu gruppieren
     * und die Summe der Werte in jeder Gruppe zu berechnen:
     *
     * <pre>{@code
     *     Map<Boolean, Integer> paritaetZuSumme = CollectionUtils.groupAndApplyFunction(
     *             Arrays.asList(1, 2, 3, 4, 5, 6),
     *             zahl -> zahl % 2 == 0,  // Gruppierung nach gerade (true) oder ungerade (false)
     *             gruppe -> gruppe.stream().mapToInt(Integer::intValue).sum());
     * }</pre>
     *
     * @param <T> der Typ der Elemente in der Liste
     * @param <K> der Typ des Schlüssels, der für die Gruppierung verwendet wird
     * @param <R> der Typ des Ergebnisses, das von der Funktion erzeugt wird
     * @param liste die Liste der zu gruppierenden Elemente
     * @param schluesselSelektor die Funktion, die den Gruppierungsschlüssel extrahiert
     * @param gruppenFunktion die Funktion, die auf jede Gruppe angewendet wird
     * @return eine Map, bei der die Schlüssel die Gruppierungsschlüssel und die Werte die Ergebnisse der angewendeten Funktion sind
     * @throws NullPointerException wenn ein Argument null ist
     */
    public static <T, K, R> Map<K, R> groupAndApplyFunction(
            List<T> liste,
            Function<? super T, ? extends K> schluesselSelektor,
            Function<List<T>, R> gruppenFunktion) {

        Objects.requireNonNull(liste);
        Objects.requireNonNull(schluesselSelektor);
        Objects.requireNonNull(gruppenFunktion);

        return liste.stream()
                    .collect(Collectors.groupingBy(
                            schluesselSelektor,
                            Collectors.collectingAndThen(Collectors.toList(), gruppenFunktion)
                    ));
    }
}
