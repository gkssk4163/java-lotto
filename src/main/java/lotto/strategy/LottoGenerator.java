package lotto.strategy;

import java.util.List;

public interface LottoGenerator {

    List<Integer> generate(int minLottoNumber, int maxLottoNumber, int lottoNumberCount);

}
