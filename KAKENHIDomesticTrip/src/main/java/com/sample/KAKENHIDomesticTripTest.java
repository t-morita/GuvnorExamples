package com.sample;

import org.drools.*;
import org.drools.agent.*;
import org.drools.builder.*;
import org.drools.definition.type.*;
import org.drools.io.*;
import org.drools.io.impl.*;
import org.drools.runtime.*;

public class KAKENHIDomesticTripTest {
	public static void main(String[] args) {
		try {
			KnowledgeAgent kagent = KnowledgeAgentFactory.newKnowledgeAgent("KAKENHIDomesticTripAgent");

			UrlResource url = (UrlResource) ResourceFactory
					.newUrlResource("http://127.0.0.1:8080/guvnor-5.5.0.Final-jboss-as-7.0/" +
							"org.drools.guvnor.Guvnor/package/KAKENHIDomesticTrip/TEST");
			url.setBasicAuthentication("enabled");
			url.setUsername("admin");
			url.setPassword("admin");

			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			kbuilder.add(url, ResourceType.PKG);

			KnowledgeBase kbase = kagent.getKnowledgeBase();
			kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

			final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
			FactType tripModel = kbase.getFactType("KAKENHIDomesticTrip", "KAKENHIDomesticTripModel");
			Object sato = tripModel.newInstance();
			tripModel.set(sato, "name", "ç≤ì°");
			tripModel.set(sato, "jobTitle", "ã≥éˆ");
			ksession.insert(sato);

			ksession.fireAllRules();
			System.out.println("ÅyÉãÅ[Éãé¿çsåãâ Åz" + tripModel.get(sato, "name") + tripModel.get(sato, "jobTitle") + 
					"ÇÃì˙ìñÅF" + tripModel.get(sato, "dailyAllowance") + "â~");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
