package com.packt.pfextensions.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.extensions.event.LayoutCompleteEvent;
import org.primefaces.extensions.model.fluidgrid.FluidGridItem;

import com.packt.pfextensions.model.Company;

	@ManagedBean
	@ViewScoped
	public class EmployerController implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private List<FluidGridItem> companies;

		@PostConstruct
		protected void initialize() {
			companies = new ArrayList<FluidGridItem>();
			for (int j = 0; j < 3; j++) { 
				for (int i = 0; i <= 16; i++) {
					companies.add(new FluidGridItem(new Company("company"+i + ".jpg")));
				}
			}
		}

		public List<FluidGridItem> getCompanies() {
			return companies;
		}

		public void fireLayoutComplete(LayoutCompleteEvent event) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fluid grid has been laid out", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	            
