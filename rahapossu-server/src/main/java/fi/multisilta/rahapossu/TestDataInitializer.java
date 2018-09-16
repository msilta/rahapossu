package fi.multisilta.rahapossu;

import fi.multisilta.rahapossu.model.portfolio.Asset;
import fi.multisilta.rahapossu.model.portfolio.AssetType;
import fi.multisilta.rahapossu.model.portfolio.Portfolio;
import fi.multisilta.rahapossu.repo.AssetRepository;
import fi.multisilta.rahapossu.repo.PortfolioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class TestDataInitializer implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(TestDataInitializer.class);

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public void run(String... args) throws Exception {

        Portfolio portfolio1 = new Portfolio();
        portfolio1.setName("Test portfolio");
        portfolio1 = portfolioRepository.save(portfolio1);
        LOG.info("Created: {}", portfolio1);

        Asset asset1 = createAsset(portfolio1, "Pankki A", AssetType.BANK_ACCOUNT, null);
        asset1 = assetRepository.save(asset1);
        LOG.info("Created: {}", asset1);

        Asset asset2 = createAsset(portfolio1, "Pankki B", AssetType.BANK_ACCOUNT, null);
        asset2 = assetRepository.save(asset2);
        LOG.info("Created: {}", asset2);

        Asset asset3 = createAsset(portfolio1, "Alphabet Inc", AssetType.STOCK, "GOOGL");
        asset3 = assetRepository.save(asset3);
        LOG.info("Created: {}", asset3);

        Asset asset4 = createAsset(portfolio1, "Kehittyvät ETF", AssetType.ETF, "IS3N");
        asset4 = assetRepository.save(asset4);
        LOG.info("Created: {}", asset4);

        Asset asset5 = createAsset(portfolio1, "Oma asunto", AssetType.PROPERTY, null);
        asset5 = assetRepository.save(asset5);
        LOG.info("Created: {}", asset5);
    }

    private Asset createAsset(Portfolio portfolio, String name, AssetType type, String symbol) {
        Asset asset = new Asset();
        asset.setName(name);
        asset.setPortfolio(portfolio);
        asset.setType(type);
        asset.setSymbol(symbol);
        return asset;
    }
}
