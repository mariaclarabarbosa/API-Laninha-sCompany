package com.laninhacompany.ecommerce.form;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

public class PedidoForm {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double total;
	
	private LocalDate data_pedido = LocalDate.now();
	
	@NotNull
	private Integer id_pagamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(LocalDate data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Integer getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(Integer id_pagamento) {
		this.id_pagamento = id_pagamento;
	}
	
}
