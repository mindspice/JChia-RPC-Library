package io.mindspice.schemas.Objects;

import io.mindspice.enums.ObjectType;
import io.mindspice.schemas.BlockChainObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public record SpendBundle(
        String aggregated_signature,
        List<CoinSpend> coin_spends,
        String puzzle_reveal,
        String solution
) implements BlockChainObject {
    public SpendBundle(SpendBundleOld spendBundle) {
        this(
                spendBundle.aggregated_signature(),
                spendBundle.coin_solutions() == null
                        ? List.of()
                        : Collections.unmodifiableList(spendBundle.coin_solutions()),
                spendBundle.puzzle_reveal(),
                spendBundle.solution()
        );
    }


    public SpendBundle {
        coin_spends = coin_spends == null ? List.of() : Collections.unmodifiableList(coin_spends);
    }


    @Override
    public ObjectType getObjectType() {
        return ObjectType.SPEND_BUNDLE;
    }
}