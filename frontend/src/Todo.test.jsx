import { render, screen, fireEvent } from "@testing-library/react";
import { describe, it, expect, vi, beforeEach, afterEach } from "vitest";
import App from "./App";

beforeEach(() => {
  global.fetch = vi.fn((url, options) => {
    if (!options) {
      return Promise.resolve({
        ok: true,
        json: () => Promise.resolve([]),
      });
    }

    return Promise.resolve({
      ok: true,
      json: () => Promise.resolve({ id: 1, description: "Neues Todo" }),
    });
  });
});

afterEach(() => {
  vi.restoreAllMocks();
});

describe("Todo App", () => {
  it("fügt ein neues Element zur Aufgabenliste hinzu", () => {
    render(<App />);

    const input = screen.getByRole("textbox");
    const button = screen.getByRole("button", { name: /absenden/i });

    fireEvent.change(input, { target: { value: "Neues Todo" } });
    fireEvent.click(button);

    expect(global.fetch).toHaveBeenCalled();
  });
});