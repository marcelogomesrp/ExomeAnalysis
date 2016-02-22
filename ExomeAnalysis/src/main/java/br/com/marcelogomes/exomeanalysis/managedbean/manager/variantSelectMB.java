/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcelogomes.exomeanalysis.managedbean.manager;

import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.Variant;
import br.com.marcelogomes.exomeanalysis.service.VariantService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Named(value = "variantSelectMB")
@SessionScoped
public class variantSelectMB implements Serializable {
    private Project project;
    private List<Variant> listUnSelect = new ArrayList<Variant>();
    private List<Variant> listSelect = new ArrayList<Variant>();
    @Inject
    private VariantService variantService;
            
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Variant> getListUnSelect() {
        return listUnSelect;
    }

    public void setListUnSelect(List<Variant> listUnSelect) {
        this.listUnSelect = listUnSelect;
    }

    public List<Variant> getListSelect() {
        return listSelect;
    }

    public void setListSelect(List<Variant> listSelect) {
        this.listSelect = listSelect;
    }


    
    public String showPage(Project project){
        this.project = project;
        this.updateLists();
        return "variant_select";
    }
    private void updateLists(){
        this.listUnSelect = variantService.findByProjectUnselected(project);
        this.listSelect = variantService.findByProjectSelected(project);
    }
    
    public void selectVariant(Variant variant){
        variantService.selectVariant(variant);
        this.updateLists();
    }
    
    public void unselectVariant(Variant variant){
        variantService.unselectVariant(variant);
        this.updateLists();
    }


    public variantSelectMB() {
    }
    
}
