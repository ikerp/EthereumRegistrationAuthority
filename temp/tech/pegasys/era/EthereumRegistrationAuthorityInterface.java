package tech.pegasys.era;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class EthereumRegistrationAuthorityInterface extends Contract {
    private static final String BINARY = "";

    public static final String FUNC_GETVERSION = "getVersion";

    public static final String FUNC_REMOVEDOMAIN = "removeDomain";

    public static final String FUNC_HASDOMAIN = "hasDomain";

    public static final String FUNC_GETDOMAININFO = "getDomainInfo";

    public static final String FUNC_GETDOMAINOWNER = "getDomainOwner";

    public static final String FUNC_ADDUPDATEDOMAIN = "addUpdateDomain";

    public static final String FUNC_GETAUTHORITY = "getAuthority";

    public static final Event DOMAINADDUPDATE_EVENT = new Event("DomainAddUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event DOMAINREMOVED_EVENT = new Event("DomainRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected EthereumRegistrationAuthorityInterface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EthereumRegistrationAuthorityInterface(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EthereumRegistrationAuthorityInterface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EthereumRegistrationAuthorityInterface(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getVersion() {
        final Function function = new Function(FUNC_GETVERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> removeDomain(BigInteger _domainHash) {
        final Function function = new Function(
                FUNC_REMOVEDOMAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_domainHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> hasDomain(BigInteger _domainHash) {
        final Function function = new Function(FUNC_HASDOMAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_domainHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> getDomainInfo(BigInteger _domainHash) {
        final Function function = new Function(FUNC_GETDOMAININFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_domainHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getDomainOwner(BigInteger _domainHash) {
        final Function function = new Function(FUNC_GETDOMAINOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_domainHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addUpdateDomain(BigInteger _domainHash, String _domainAuthority, String _domainInfo, String _domainOwner) {
        final Function function = new Function(
                FUNC_ADDUPDATEDOMAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_domainHash), 
                new org.web3j.abi.datatypes.Address(_domainAuthority), 
                new org.web3j.abi.datatypes.Address(_domainInfo), 
                new org.web3j.abi.datatypes.Address(_domainOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getAuthority(BigInteger _domainHash) {
        final Function function = new Function(FUNC_GETAUTHORITY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_domainHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public List<DomainAddUpdateEventResponse> getDomainAddUpdateEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DOMAINADDUPDATE_EVENT, transactionReceipt);
        ArrayList<DomainAddUpdateEventResponse> responses = new ArrayList<DomainAddUpdateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DomainAddUpdateEventResponse typedResponse = new DomainAddUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._domainHash = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._domainAuthority = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._orgInfo = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DomainAddUpdateEventResponse> domainAddUpdateEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DomainAddUpdateEventResponse>() {
            @Override
            public DomainAddUpdateEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DOMAINADDUPDATE_EVENT, log);
                DomainAddUpdateEventResponse typedResponse = new DomainAddUpdateEventResponse();
                typedResponse.log = log;
                typedResponse._domainHash = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._domainAuthority = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._orgInfo = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DomainAddUpdateEventResponse> domainAddUpdateEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DOMAINADDUPDATE_EVENT));
        return domainAddUpdateEventObservable(filter);
    }

    public List<DomainRemovedEventResponse> getDomainRemovedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DOMAINREMOVED_EVENT, transactionReceipt);
        ArrayList<DomainRemovedEventResponse> responses = new ArrayList<DomainRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DomainRemovedEventResponse typedResponse = new DomainRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._domainHash = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DomainRemovedEventResponse> domainRemovedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DomainRemovedEventResponse>() {
            @Override
            public DomainRemovedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DOMAINREMOVED_EVENT, log);
                DomainRemovedEventResponse typedResponse = new DomainRemovedEventResponse();
                typedResponse.log = log;
                typedResponse._domainHash = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DomainRemovedEventResponse> domainRemovedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DOMAINREMOVED_EVENT));
        return domainRemovedEventObservable(filter);
    }

    public static RemoteCall<EthereumRegistrationAuthorityInterface> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EthereumRegistrationAuthorityInterface.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EthereumRegistrationAuthorityInterface> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EthereumRegistrationAuthorityInterface.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EthereumRegistrationAuthorityInterface> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EthereumRegistrationAuthorityInterface.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EthereumRegistrationAuthorityInterface> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EthereumRegistrationAuthorityInterface.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static EthereumRegistrationAuthorityInterface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EthereumRegistrationAuthorityInterface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EthereumRegistrationAuthorityInterface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EthereumRegistrationAuthorityInterface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EthereumRegistrationAuthorityInterface load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EthereumRegistrationAuthorityInterface(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EthereumRegistrationAuthorityInterface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EthereumRegistrationAuthorityInterface(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class DomainAddUpdateEventResponse {
        public Log log;

        public BigInteger _domainHash;

        public String _domainAuthority;

        public String _orgInfo;

        public String _owner;
    }

    public static class DomainRemovedEventResponse {
        public Log log;

        public BigInteger _domainHash;
    }
}
