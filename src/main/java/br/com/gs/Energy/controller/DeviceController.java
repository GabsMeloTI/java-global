package br.com.gs.Energy.controller;

import br.com.gs.Energy.model.Device;
import br.com.gs.Energy.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        deviceRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Livro removido!");
        return "redirect:/device/listar";
    }
}
