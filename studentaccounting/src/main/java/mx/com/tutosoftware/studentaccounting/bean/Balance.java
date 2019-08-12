package mx.com.tutosoftware.studentaccounting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;



@ManagedBean
@SessionScoped
public class Balance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String empresa;
	private Date fecha;
	private String fechaBalance;
	private String tipoCuenta;
	private String nombreCuenta;
	private static ArrayList<Reporte> reportes = new ArrayList<Reporte>();
	
	
	
	
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaBalance() {
		return fechaBalance;
	}

	public void setFechaBalance(String fechaBalance) {
		this.fechaBalance = fechaBalance;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public ArrayList<Reporte> getReportes() {
		return reportes;
	}
	
	public void mostrarFecha() {
		Calendar cal= Calendar.getInstance();
		cal.setTime(fecha);
		int dia=cal.get(Calendar.DAY_OF_MONTH);
		int mes=cal.get(Calendar.MONTH)+1;
		int year=cal.get(Calendar.YEAR);
		
		String mesString;
		
		switch (mes) {
        case 1:  mesString = "Enero";
                 break;
        case 2:  mesString  = "Febrero";
                 break;
        case 3:  mesString = "Marzo";
                 break;
        case 4:  mesString = "Abril";
                 break;
        case 5:  mesString = "Mayo";
                 break;
        case 6:  mesString = "Junio";
                 break;
        case 7:  mesString = "Julio";
                 break;
        case 8:  mesString = "Agosto";
                 break;
        case 9:  mesString = "Septiembre";
                 break;
        case 10: mesString = "Octubre";
                 break;
        case 11: mesString = "Noviembre";
                 break;
        case 12: mesString = "Diciembre";
                 break;
        default: mesString = "Invalid month";
                 break;
        }
		
		
		
	 fechaBalance="Balance General al "+dia+" de "+mesString+" "+year;
		
		
		
		
		
	}
	public void agregarReporte() {
		
    	Reporte reporte1 = new Reporte(this.tipoCuenta,this.nombreCuenta,0.0,0.0,0.0);
    	
    	
    	reportes.add(reporte1);
    	this.nombreCuenta="";
		
	}
	
	
	public void limpiarReporte() {
		fechaBalance = " ";
		empresa = "";
		reportes.clear();
	}
	
	public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Cuenta editada",((Reporte) event.getObject()).getConcepto());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Cuenta cancelada");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        reportes.remove((Reporte) event.getObject());
    }
    
   

}



