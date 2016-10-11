package com.varian.ois.sample.exploringaxon.repositories;

import com.varian.ois.sample.exploringaxon.model.AccountEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by gbt1220 on 9/27/2016.
 */
public interface AccountQueryRepository  extends PagingAndSortingRepository<AccountEntity, String> {

    AccountEntity findByIdentifier(String identifier);
}
