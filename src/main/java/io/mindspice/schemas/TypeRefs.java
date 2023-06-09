package io.mindspice.schemas;

import com.fasterxml.jackson.core.type.TypeReference;
import io.mindspice.schemas.farmer.*;
import io.mindspice.schemas.object.*;
import io.mindspice.schemas.shared.Connection;
import io.mindspice.schemas.wallet.Notification;
import io.mindspice.schemas.wallet.cat.Cat;
import io.mindspice.schemas.wallet.cat.StrayCat;
import io.mindspice.schemas.wallet.Transaction;
import io.mindspice.schemas.wallet.nft.NftInfo;
import io.mindspice.schemas.wallet.nft.NftWallet;
import io.mindspice.schemas.wallet.nft.RoyaltyCalculation;

import java.util.List;
import java.util.Map;


public class TypeRefs {
    public static final TypeReference<List<BlockRecord>> BLOCK_RECORD_LIST = new TypeReference<>() { };
    public static final TypeReference<List<Block>> BLOCK_LIST = new TypeReference<>() { };
    public static final TypeReference<List<CoinRecord>> COIN_RECORD_LIST = new TypeReference<>() { };
    public static final TypeReference<List<CoinSolution>> COIN_SOLUTION_LIST = new TypeReference<>() { };
    public static final TypeReference<List<BlockHeader>> BLOCK_HEADER_LIST = new TypeReference<>() { };
    public static final TypeReference<List<String>> STRING_LIST = new TypeReference<>() { };
    public static final TypeReference<Map<String, MempoolItem>> MEMPOOL_MAP = new TypeReference<>() { };
    public static final TypeReference<List<Plot>> PLOT_LIST = new TypeReference<>() { };
    public static final TypeReference<List<HarvesterDetails>> HARVESTER_DETAILS_LIST = new TypeReference<>() { };
    public static final TypeReference<List<HarvesterSummary>> HARVESTER_SUMMARY_LIST = new TypeReference<>() { };
    public static final TypeReference<List<PoolState>> POOL_STATE_LIST = new TypeReference<>() { };
    public static final TypeReference<List<RewardTarget>> REWARD_TARGET_LIST = new TypeReference<>() { };
    public static final TypeReference<List<SignagePointBundle>> SIGNAGE_POINT_BUNDLE_LIST = new TypeReference<>() { };
    public static final TypeReference<List<Cat>> CAT_LIST = new TypeReference<>() { };
    public static final TypeReference<List<StrayCat>> STRAY_CAT_LIST = new TypeReference<>() { };
    public static final TypeReference<List<Coin>> COIN_LIST = new TypeReference<>() { };
    public static final TypeReference<List<Notification>> NOTIFICATION_LIST = new TypeReference<>() { };
    public static final TypeReference<List<Transaction>> TRANSACTIONS_LIST = new TypeReference<>() { };
    public static final TypeReference<List<NftInfo>> NFT_INFO_LIST = new TypeReference<>() { };
    public static final TypeReference<List<NftWallet>> NFT_WALLET_LIST = new TypeReference<>() { };
    public static final TypeReference<Map<String, List<String>>> MEMO_MAP = new TypeReference<>() { };
    public static final TypeReference<Map<String, List<RoyaltyCalculation>>> ROYALTY_MAP = new TypeReference<>() { };
    public static final TypeReference<List<Connection>> CONNECTION_LIST = new TypeReference<>() { };
}

