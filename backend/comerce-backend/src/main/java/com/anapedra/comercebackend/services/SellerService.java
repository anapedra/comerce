package com.anapedra.comercebackend.services;

public class SellerService {
    /*

	@Transactional(readOnly = true)
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
     @Transactional(readOnly = true)
	public Page<SaleDTO> findAllSale(String minDate, String maxDate,String name, Pageable pageable){
		LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
		Page<Sale> page=repository.findAllSale(min,max,name,pageable);
		repository.findAllSales(page.stream().collect(Collectors.toList()));
		return page.map(SaleDTO::new);
	}
	@Transactional(readOnly = true)
	public List<SaleSummaryDTO> findSummary(String minDate, String maxDate){
		LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
		List<Sale> list=repository.findAllSummary(min,max);
		return list.stream().map(SaleSummaryDTO::new).collect(Collectors.toList());
	}


     */
}
