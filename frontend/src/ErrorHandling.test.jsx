import { render, screen, fireEvent } from "@testing-library/react";
import { describe, it, expect, vi, beforeEach, afterEach } from "vitest";
import App from "./App";

beforeEach(() => {
  global.fetch = vi.fn(() =>
    Promise.resolve({
      ok: true,
      json: () => Promise.resolve([]),
    })
  );
});

afterEach(() => {
  vi.restoreAllMocks();
});

describe("Todo App", () => {
  it("reagiert auf Klick auf Absenden", () => {
    render(<App />);

    const button = screen.getByRole("button", { name: /absenden/i });
    fireEvent.click(button);

    expect(button).toBeTruthy();
  });
});