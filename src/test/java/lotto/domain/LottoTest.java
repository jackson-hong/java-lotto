package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 동일한 갯수 반환 확인 - 6개")
    void testIfGetLottoCorrectCount6() {
        Lotto lotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));

        Lotto winningLottoNumbers = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));

        int result = lotto.getSameElementsSize(winningLottoNumbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호가 동일한 갯수 반환 확인 - 5개")
    void testIfGetLottoCorrectCount5() {
        Lotto lotto = Lotto.from(Set.of(1, 2, 33, 4, 5, 6));

        Lotto winningLottoNumbers = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));

        int result = lotto.getSameElementsSize(winningLottoNumbers);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 갯수가 6개가 넘을 경우 Exception 확인")
    void testIfThrowExceptionWithTooBigLottoSize() {
        assertThatThrownBy(() -> Lotto.from(Set.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("lotto input has wrong size");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 Exception 확인")
    void testIfThrowExceptionWithDuplicateNumbers() {
        assertThatThrownBy(() -> Lotto.from(new TreeSet<>(Arrays.asList(1,2,3,4,6,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("lotto input has wrong size");
    }
}
