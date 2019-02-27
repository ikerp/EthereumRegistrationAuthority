package tech.pegasys.era;

import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.Hash;
import org.web3j.protocol.core.RemoteCall;
import tech.pegasys.era.internal.AutoGeneratedFinder;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Finder Java Wrapper Class.
 */
public class Finder {

    private AutoGeneratedFinder finderAutoGenWrapperReal;

    public Finder(RemoteCall<AutoGeneratedFinder> finderAutoGenWrapper) throws Exception {
        finderAutoGenWrapperReal = finderAutoGenWrapper.send();
    }

    public Finder(AutoGeneratedFinder finderAutoGenWrapperReal) {
        this.finderAutoGenWrapperReal = finderAutoGenWrapperReal;
    }

    /**
     * Get the contract address of the Era.
     * @return - The contract address.
     */
    public String getContractAddress() {
        return finderAutoGenWrapperReal.getContractAddress();
    }

    public String resolveDomain(List<String> eras, String domainName,
                                            String p1DomainName, String p2DomainName,
                                            String p3DomainName) throws Exception {
        BigInteger domainHash = getDomainHash(domainName);
        BigInteger p1DomainHash = getDomainHash(p1DomainName);
        BigInteger p2DomainHash = getDomainHash(p2DomainName);
        BigInteger p3DomainHash = getDomainHash(p3DomainName);
        return finderAutoGenWrapperReal.resolveDomain(eras, domainHash, p1DomainHash, p2DomainHash, p3DomainHash).send();
    }

    public List resolveDomains(List<String> eras, List<String> domainNames,
                                           List<String> p1DomainNames, List<String> p2DomainNames,
                                           List<String> p3DomainNames) throws Exception {
        List<BigInteger> domainHashes = new ArrayList<>();
        List<BigInteger> p1DomainHashes = new ArrayList<>();
        List<BigInteger> p2DomainHashes = new ArrayList<>();
        List<BigInteger> p3DomainHashes = new ArrayList<>();
        for (String domainName : domainNames) domainHashes.add(getDomainHash(domainName));
        for (String p1DomainName : p1DomainNames) p1DomainHashes.add(getDomainHash(p1DomainName));
        for (String p2DomainName : p2DomainNames) p2DomainHashes.add(getDomainHash(p2DomainName));
        for (String p3DomainName : p3DomainNames) p3DomainHashes.add(getDomainHash(p3DomainName));
        return finderAutoGenWrapperReal.resolveDomains(eras, domainHashes, p1DomainHashes, p2DomainHashes, p3DomainHashes).send();
    }

    public BigInteger getVersion() throws Exception {
        return finderAutoGenWrapperReal.getVersion().send();
    }

    /**
     * Get the BigInteger representation of given domain name.
     * @param domainName - String of domain name.
     * @return Keccak256 Hash of the given domain name in BigInteger representation.
     */
    private BigInteger getDomainHash(String domainName) {
        String hexString = Hash.sha3(Hex.toHexString(domainName.getBytes(StandardCharsets.UTF_8))).substring(2);
        return new BigInteger(hexString, 16);
    }
}