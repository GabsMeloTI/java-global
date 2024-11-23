package br.com.gs.Energy.controller;

import br.com.gs.Energy.model.Device;
import br.com.gs.Energy.repository.DeviceRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("device")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Device device){
        return "device/cadastrar";
    }
    @PostMapping("save")
    @Transactional
    @Operation(summary = "Cadastro de Post",
            description = "Cadastra um Post")
    public String saveDevice(Device device, RedirectAttributes redirectAttributes) {
        deviceRepository.save(device);
        redirectAttributes.addFlashAttribute("msg", "Aparelho cadastrado com sucesso!!!");
        return "redirect:/device/cadastrar"; // Redireciona para a página de cadastro
    }

    @GetMapping("listar")

    public String listar(Model model){
        var devices = deviceRepository.findAll();
        System.out.println(devices);
        model.addAttribute("devices", devices);
        return "device/listar";
    }

    @GetMapping("edit/{id}")
    @Parameters({
            @Parameter(name="id", description = "Pesquisa post por id", required = true)
    })
    public String editar(@PathVariable("id")Integer id, Model model){
        model.addAttribute("device", deviceRepository.findById(id));
        return "device/edit";
    }

    @PostMapping("edit")
    public String editarSave(Device device, RedirectAttributes redirectAttributes) {
        deviceRepository.save(device);

        redirectAttributes.addFlashAttribute("msg", "Atualizado com sucesso!!!");
        return "redirect:/device/listar";
    }


    @PostMapping("delete")
    @Operation(summary = "Exclui um dispositivo", description = "Exclui um dispositivo baseado no ID fornecido.")
    public String delete( Integer id, RedirectAttributes redirectAttributes) {
        deviceRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Livro removido!");
        return "redirect:/device/listar";
    }
}
