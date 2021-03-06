package com.ruubel.service.observer;

import com.ruubel.model.BankInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 *
 * This service is very interested in events that take place in BankService,
 * so it subscribes itself to BankInformationPublisherService.
 * This service chooses to "save" the results (for demo sake).
 */
@Service
public class SaverService implements BankInformationReceived {

	private BankInformationPublisherService bankInformationPublisherService;

	@Autowired
	public SaverService(BankInformationPublisherService bankInformationPublisherService) {
		this.bankInformationPublisherService = bankInformationPublisherService;
		this.bankInformationPublisherService.subscribe(this);
	}

	@Override
	public void receivedBankInformation(List<BankInformation> data) {
		System.out.println("Saving: " + data);
	}
}
