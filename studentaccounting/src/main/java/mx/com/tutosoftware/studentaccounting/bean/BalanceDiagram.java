package mx.com.tutosoftware.studentaccounting.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultOrganigramNode;
import org.primefaces.model.OrganigramNode;

@ManagedBean
@ViewScoped
public class BalanceDiagram implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrganigramNode rootNode;
	
	@PostConstruct
    public void init() {
		rootNode = new DefaultOrganigramNode("root", "Balance General", null);
        rootNode.setCollapsible(false);
        rootNode.setDroppable(true);
        
        
        OrganigramNode activo = addDivision(rootNode, "Activo");
        
        
        
        OrganigramNode activoCirculante = addDivision(activo, "Activo Circulante");
        addDivision(activoCirculante, "Caja", "Bancos","Clientes","Almacén"
        		,"Documentos por cobrar");
        
        OrganigramNode activoFijo = addDivision(activo, "Activo Fijo");
        addDivision(activoFijo, "Equipo de oficina", "Edificios","Terrenos","Equipo de reparto"
        		,"Patentes y marcas","Depósitos en garantía","Deudores hipotecarios"
        		,"Aciones,bonos y valores","Papelería y artículos de escritorio"
        		,"Propagenda y publicidad");
        
        OrganigramNode cargosDiferidos = addDivision(activo, "Cargos Diferidos");
        addDivision(cargosDiferidos, "Primas de seguros adelantados", "Gastos de instalación"
        		,"Rentas anticipadas","Intereses pagados por anticipado");
        
        OrganigramNode pasivo = addDivision(rootNode,"Pasivo");
        
        OrganigramNode pasivoCirculante = addDivision(pasivo, "Pasivo Circulante o Flotante");
        addDivision(pasivoCirculante, "Proveedores", "Acreedores Diversos","Impuestos por pagar","Documentos por pagar");
        
        OrganigramNode pasivoFijo = addDivision(pasivo, "Pasivo Fijo o Consolidado");
        addDivision(pasivoFijo,"Documentos por pagar a largo plazo","Acreedores hipotecarios");
        
        OrganigramNode creditosDiferidos = addDivision(pasivo, "Créditos diferidos");
        addDivision(creditosDiferidos,"Rentas cobradas por adelantado","Intereses cobrados anticipadamente");
        
        
        
        OrganigramNode capital = addDivision(rootNode,"Capital");
        addDivision(capital,"Ventas","Costo de ventas","Gastos de administración"
        		,"Gastos y productos financieros","Otros gastos y productos"
        		,"Impuestos sobre la renta","Pérdidas y ganancias","Capital");
	}
	
	protected OrganigramNode addDivision(OrganigramNode parent, String name, String... cuentas) {
        OrganigramNode divisionNode = new DefaultOrganigramNode("division", name, parent);
        divisionNode.setDroppable(true);
        divisionNode.setDraggable(true);
        divisionNode.setSelectable(true);
 
        if (cuentas != null) {
            for (String cuenta : cuentas) {
                OrganigramNode employeeNode = new DefaultOrganigramNode("employee", cuenta, divisionNode);
                employeeNode.setDraggable(true);
                employeeNode.setSelectable(true);
            }
        }
 
        return divisionNode;
    }

	public OrganigramNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(OrganigramNode rootNode) {
		this.rootNode = rootNode;
	}

}
