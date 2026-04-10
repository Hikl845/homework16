package com.example.homeworkmodule16.entity.controllers;

import com.example.homeworkmodule16.entity.Note;
import com.example.homeworkmodule16.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import static com.sun.tools.javac.resources.CompilerProperties.Notes.Note;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // Список нотаток
    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note-list";
    }

    // Видалення нотатки
    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    // Сторінка редагування
    @GetMapping("/edit")
    public String editNotePage(@RequestParam long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note-edit";
    }

    // Обробка редагування
    @PostMapping("/edit")
    public String editNoteSubmit(@RequestParam String title,
                                 @RequestParam String content) {
        Note note = new Note();
        //note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return "redirect:/note/list";
    }
}
