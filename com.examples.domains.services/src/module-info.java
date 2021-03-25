module com.examples.domains.services {
	requires com.examples.contracts;
	requires com.examples.domains;
	requires com.examples.infraestructure;
	
	exports com.examples.domains.services;
	// Proveedor
	exports com.examples.domains.services.config;
	provides com.examples.contracts.Configuracion with com.examples.domains.services.config.ConfiguracionImp;
}