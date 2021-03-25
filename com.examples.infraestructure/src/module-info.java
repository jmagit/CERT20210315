module com.examples.infraestructure {
	requires com.examples.contracts;
	requires com.examples.domains;
	
	exports com.examples.repositories to com.examples.domains.services;
	// Proveedor
	exports com.examples.infraestructure.config;
	provides com.examples.contracts.Configuracion with com.examples.infraestructure.config.ConfiguracionImp;
}