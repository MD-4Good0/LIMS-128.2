package com.backend.lims.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestId;

	public enum TestingPurpose {
		Monitoring, Local_Trade, Imported, Export, Complaint, Others
	}

	public enum RequestStatus {
		PENDING_REVIEW, FOR_TESTING, FOR_RELEASE, REJECTED, RELEASED
	}

	// Client Information
	@ManyToOne
	private Client client;  // Prefilled client information based on logged-in user
	private Long representativeId;
	private String representativeName;
	private String contactNumber;
	private String emailAddress;
	private String companyName;
	private String clientClassification;
	private String ltoNumber;

	// Sample Information
	@OneToMany(targetEntity = Sample.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fkRequestId", referencedColumnName = "requestId")
	private List<Sample> sample; // Creates separate string for sample descriptions

	private String lotBatchNo;
	private String sampleSource;
	private String sampleProvince;
	private String sampleAddress;
	private String sampleCategory;
	private LocalDate productionDate;
	private LocalDate expiryDate;
	private LocalDate samplingDate;
	private String samplerName;

	// Purpose of Testing (ENUM for better management)
	@Enumerated(EnumType.STRING)
	private TestingPurpose testingPurpose;

	private Boolean isMicrobio;

	private Boolean isChem;

	private Boolean isMolBio;

	// CHEM TEST RESULTS

	// Microbial Inhibition
	@Column
	private Boolean microbial;
	private Boolean betaLactams;
	private Boolean tetracyclines;
	private Boolean sulfonamides;
	private Boolean aminoglycosides;
	private Boolean macrolides;
	private Boolean quinolones;

	// Enzyme-Linked ImmunoSorbent
	@Column
	private Boolean elisa;
	private Boolean chloramphenicol;
	private Boolean nitrofuranAoz;
	private Boolean beta_agonists;
	private Boolean corticosteroids;
	private Boolean olaquindox;
	private Boolean nitrufuranAmoz;
	private Boolean stilbenes;
	private Boolean ractopamine;

	// MICROBIO TEST RESULTS
	private Boolean standardPlateCount;
	private Boolean staphylococcusAureus;
	private Boolean salmonellaSp;
	private Boolean campylobacter;
	private Boolean cultureAndSensitivityTest;
	private String gramPositiveAst;
	private String gramNegativeAst;
	private Boolean coliformCount;
	private Boolean eColi;
	private Boolean eColiAndeColi0O157;
	private Boolean yeastAndMolds;

	// MOLBIO TEST RESULTS
	@Column
	private Boolean speciesIdentification;
	private Boolean dog;
	private Boolean cat;
	private Boolean chicken;
	private Boolean buffalo;
	private Boolean cattle;
	private Boolean horse;
	private Boolean goat;
	private Boolean sheep;
	private Boolean swine;

	// Request Status
	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;

	// Control Number
	// What is this control number
	private String controlNumber;

	// Submission Date
	private LocalDate submissionDate;

	// Timestamps
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Column(name = "other_testing_purpose")
	private String otherTestingPurpose;

	public Request() {
	}

	public Request(Long requestId, Client client, Long representativeId, String representativeName, String contactNumber, String emailAddress, String companyName, String clientClassification, String ltoNumber, List<Sample> sample, String lotBatchNo, String sampleSource, String sampleProvince, String sampleAddress, String sampleCategory, LocalDate productionDate, LocalDate expiryDate, LocalDate samplingDate, String samplerName, TestingPurpose testingPurpose, Boolean isMicrobio, Boolean isChem, Boolean isMolBio, Boolean microbial, Boolean betaLactams, Boolean tetracyclines, Boolean sulfonamides, Boolean aminoglycosides, Boolean macrolides, Boolean quinolones, Boolean elisa, Boolean chloramphenicol, Boolean nitrofuranAoz, Boolean beta_agonists, Boolean corticosteroids, Boolean olaquindox, Boolean nitrufuranAmoz, Boolean stilbenes, Boolean ractopamine, Boolean standardPlateCount, Boolean staphylococcusAureus, Boolean salmonellaSp, Boolean campylobacter, Boolean cultureAndSensitivityTest, String gramPositiveAst, String gramNegativeAst, Boolean coliformCount, Boolean eColi, Boolean eColiAndeColi0O157, Boolean yeastAndMolds, Boolean speciesIdentification, Boolean dog, Boolean cat, Boolean chicken, Boolean buffalo, Boolean cattle, Boolean horse, Boolean goat, Boolean sheep, Boolean swine, RequestStatus requestStatus, String controlNumber, LocalDate submissionDate, LocalDateTime createdAt, LocalDateTime updatedAt, String otherTestingPurpose) {
		this.requestId = requestId;
		this.client = client;
		this.representativeId = representativeId;
		this.representativeName = representativeName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.companyName = companyName;
		this.clientClassification = clientClassification;
		this.ltoNumber = ltoNumber;
		this.sample = sample;
		this.lotBatchNo = lotBatchNo;
		this.sampleSource = sampleSource;
		this.sampleProvince = sampleProvince;
		this.sampleAddress = sampleAddress;
		this.sampleCategory = sampleCategory;
		this.productionDate = productionDate;
		this.expiryDate = expiryDate;
		this.samplingDate = samplingDate;
		this.samplerName = samplerName;
		this.testingPurpose = testingPurpose;
		this.isMicrobio = isMicrobio;
		this.isChem = isChem;
		this.isMolBio = isMolBio;
		this.microbial = microbial;
		this.betaLactams = betaLactams;
		this.tetracyclines = tetracyclines;
		this.sulfonamides = sulfonamides;
		this.aminoglycosides = aminoglycosides;
		this.macrolides = macrolides;
		this.quinolones = quinolones;
		this.elisa = elisa;
		this.chloramphenicol = chloramphenicol;
		this.nitrofuranAoz = nitrofuranAoz;
		this.beta_agonists = beta_agonists;
		this.corticosteroids = corticosteroids;
		this.olaquindox = olaquindox;
		this.nitrufuranAmoz = nitrufuranAmoz;
		this.stilbenes = stilbenes;
		this.ractopamine = ractopamine;
		this.standardPlateCount = standardPlateCount;
		this.staphylococcusAureus = staphylococcusAureus;
		this.salmonellaSp = salmonellaSp;
		this.campylobacter = campylobacter;
		this.cultureAndSensitivityTest = cultureAndSensitivityTest;
		this.gramPositiveAst = gramPositiveAst;
		this.gramNegativeAst = gramNegativeAst;
		this.coliformCount = coliformCount;
		this.eColi = eColi;
		this.eColiAndeColi0O157 = eColiAndeColi0O157;
		this.yeastAndMolds = yeastAndMolds;
		this.speciesIdentification = speciesIdentification;
		this.dog = dog;
		this.cat = cat;
		this.chicken = chicken;
		this.buffalo = buffalo;
		this.cattle = cattle;
		this.horse = horse;
		this.goat = goat;
		this.sheep = sheep;
		this.swine = swine;
		this.requestStatus = requestStatus;
		this.controlNumber = controlNumber;
		this.submissionDate = submissionDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.otherTestingPurpose = otherTestingPurpose;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getRepresentativeId() {
		return representativeId;
	}

	public void setRepresentativeId(Long representativeId) {
		this.representativeId = representativeId;
	}

	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getClientClassification() {
		return clientClassification;
	}

	public void setClientClassification(String clientClassification) {
		this.clientClassification = clientClassification;
	}

	public String getLtoNumber() {
		return ltoNumber;
	}

	public void setLtoNumber(String ltoNumber) {
		this.ltoNumber = ltoNumber;
	}

	public List<Sample> getSample() {
		return sample;
	}

	public void setSample(List<Sample> sample) {
		this.sample = sample;
	}

	public String getLotBatchNo() {
		return lotBatchNo;
	}

	public void setLotBatchNo(String lotBatchNo) {
		this.lotBatchNo = lotBatchNo;
	}

	public String getSampleSource() {
		return sampleSource;
	}

	public void setSampleSource(String sampleSource) {
		this.sampleSource = sampleSource;
	}

	public String getSampleProvince() {
		return sampleProvince;
	}

	public void setSampleProvince(String sampleProvince) {
		this.sampleProvince = sampleProvince;
	}

	public String getSampleAddress() {
		return sampleAddress;
	}

	public void setSampleAddress(String sampleAddress) {
		this.sampleAddress = sampleAddress;
	}

	public String getSampleCategory() {
		return sampleCategory;
	}

	public void setSampleCategory(String sampleCategory) {
		this.sampleCategory = sampleCategory;
	}

	public LocalDate getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDate getSamplingDate() {
		return samplingDate;
	}

	public void setSamplingDate(LocalDate samplingDate) {
		this.samplingDate = samplingDate;
	}

	public String getSamplerName() {
		return samplerName;
	}

	public void setSamplerName(String samplerName) {
		this.samplerName = samplerName;
	}

	public TestingPurpose getTestingPurpose() {
		return testingPurpose;
	}

	public void setTestingPurpose(TestingPurpose testingPurpose) {
		this.testingPurpose = testingPurpose;
	}

	public String getOtherTestingPurpose() {
		return otherTestingPurpose;
	}
	public void setOtherTestingPurpose(String otherTestingPurpose) {
		this.otherTestingPurpose = otherTestingPurpose;
	}

	public Boolean getMicrobio() {
		return isMicrobio;
	}

	public void setMicrobio(Boolean microbio) {
		isMicrobio = microbio;
	}

	public Boolean getChem() {
		return isChem;
	}

	public void setChem(Boolean chem) {
		isChem = chem;
	}

	public Boolean getMolBio() {
		return isMolBio;
	}

	public void setMolBio(Boolean molBio) {
		isMolBio = molBio;
	}

	public Boolean getMicrobial() {
		return microbial;
	}

	public void setMicrobial(Boolean microbial) {
		this.microbial = microbial;
	}

	public Boolean getBetaLactams() {
		return betaLactams;
	}

	public void setBetaLactams(Boolean betaLactams) {
		this.betaLactams = betaLactams;
	}

	public Boolean getTetracyclines() {
		return tetracyclines;
	}

	public void setTetracyclines(Boolean tetracyclines) {
		this.tetracyclines = tetracyclines;
	}

	public Boolean getSulfonamides() {
		return sulfonamides;
	}

	public void setSulfonamides(Boolean sulfonamides) {
		this.sulfonamides = sulfonamides;
	}

	public Boolean getAminoglycosides() {
		return aminoglycosides;
	}

	public void setAminoglycosides(Boolean aminoglycosides) {
		this.aminoglycosides = aminoglycosides;
	}

	public Boolean getMacrolides() {
		return macrolides;
	}

	public void setMacrolides(Boolean macrolides) {
		this.macrolides = macrolides;
	}

	public Boolean getQuinolones() {
		return quinolones;
	}

	public void setQuinolones(Boolean quinolones) {
		this.quinolones = quinolones;
	}

	public Boolean getElisa() {
		return elisa;
	}

	public void setElisa(Boolean elisa) {
		this.elisa = elisa;
	}

	public Boolean getChloramphenicol() {
		return chloramphenicol;
	}

	public void setChloramphenicol(Boolean chloramphenicol) {
		this.chloramphenicol = chloramphenicol;
	}

	public Boolean getNitrofuranAoz() {
		return nitrofuranAoz;
	}

	public void setNitrofuranAoz(Boolean nitrofuranAoz) {
		this.nitrofuranAoz = nitrofuranAoz;
	}

	public Boolean getBeta_agonists() {
		return beta_agonists;
	}

	public void setBeta_agonists(Boolean beta_agonists) {
		this.beta_agonists = beta_agonists;
	}

	public Boolean getCorticosteroids() {
		return corticosteroids;
	}

	public void setCorticosteroids(Boolean corticosteroids) {
		this.corticosteroids = corticosteroids;
	}

	public Boolean getOlaquindox() {
		return olaquindox;
	}

	public void setOlaquindox(Boolean olaquindox) {
		this.olaquindox = olaquindox;
	}

	public Boolean getNitrufuranAmoz() {
		return nitrufuranAmoz;
	}

	public void setNitrufuranAmoz(Boolean nitrufuranAmoz) {
		this.nitrufuranAmoz = nitrufuranAmoz;
	}

	public Boolean getStilbenes() {
		return stilbenes;
	}

	public void setStilbenes(Boolean stilbenes) {
		this.stilbenes = stilbenes;
	}

	public Boolean getRactopamine() {
		return ractopamine;
	}

	public void setRactopamine(Boolean ractopamine) {
		this.ractopamine = ractopamine;
	}

	public Boolean getStandardPlateCount() {
		return standardPlateCount;
	}

	public void setStandardPlateCount(Boolean standardPlateCount) {
		this.standardPlateCount = standardPlateCount;
	}

	public Boolean getStaphylococcusAureus() {
		return staphylococcusAureus;
	}

	public void setStaphylococcusAureus(Boolean staphylococcusAureus) {
		this.staphylococcusAureus = staphylococcusAureus;
	}

	public Boolean getSalmonellaSp() {
		return salmonellaSp;
	}

	public void setSalmonellaSp(Boolean salmonellaSp) {
		this.salmonellaSp = salmonellaSp;
	}

	public Boolean getCampylobacter() {
		return campylobacter;
	}

	public void setCampylobacter(Boolean campylobacter) {
		this.campylobacter = campylobacter;
	}

	public Boolean getCultureAndSensitivityTest() {
		return cultureAndSensitivityTest;
	}

	public void setCultureAndSensitivityTest(Boolean cultureAndSensitivityTest) {
		this.cultureAndSensitivityTest = cultureAndSensitivityTest;
	}

	public String getGramPositiveAst() {
		return gramPositiveAst;
	}

	public void setGramPositiveAst(String gramPositiveAst) {
		this.gramPositiveAst = gramPositiveAst;
	}

	public String getGramNegativeAst() {
		return gramNegativeAst;
	}

	public void setGramNegativeAst(String gramNegativeAst) {
		this.gramNegativeAst = gramNegativeAst;
	}

	public Boolean getColiformCount() {
		return coliformCount;
	}

	public void setColiformCount(Boolean coliformCount) {
		this.coliformCount = coliformCount;
	}

	public Boolean geteColi() {
		return eColi;
	}

	public void seteColi(Boolean eColi) {
		this.eColi = eColi;
	}

	public Boolean geteColiAndeColi0O157() {
		return eColiAndeColi0O157;
	}

	public void seteColiAndeColi0O157(Boolean eColiAndeColi0O157) {
		this.eColiAndeColi0O157 = eColiAndeColi0O157;
	}

	public Boolean getYeastAndMolds() {
		return yeastAndMolds;
	}

	public void setYeastAndMolds(Boolean yeastAndMolds) {
		this.yeastAndMolds = yeastAndMolds;
	}

	public Boolean getSpeciesIdentification() {
		return speciesIdentification;
	}

	public void setSpeciesIdentification(Boolean speciesIdentification) {
		this.speciesIdentification = speciesIdentification;
	}

	public Boolean getDog() {
		return dog;
	}

	public void setDog(Boolean dog) {
		this.dog = dog;
	}

	public Boolean getCat() {
		return cat;
	}

	public void setCat(Boolean cat) {
		this.cat = cat;
	}

	public Boolean getChicken() {
		return chicken;
	}

	public void setChicken(Boolean chicken) {
		this.chicken = chicken;
	}

	public Boolean getBuffalo() {
		return buffalo;
	}

	public void setBuffalo(Boolean buffalo) {
		this.buffalo = buffalo;
	}

	public Boolean getCattle() {
		return cattle;
	}

	public void setCattle(Boolean cattle) {
		this.cattle = cattle;
	}

	public Boolean getHorse() {
		return horse;
	}

	public void setHorse(Boolean horse) {
		this.horse = horse;
	}

	public Boolean getGoat() {
		return goat;
	}

	public void setGoat(Boolean goat) {
		this.goat = goat;
	}

	public Boolean getSheep() {
		return sheep;
	}

	public void setSheep(Boolean sheep) {
		this.sheep = sheep;
	}

	public Boolean getSwine() {
		return swine;
	}

	public void setSwine(Boolean swine) {
		this.swine = swine;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}